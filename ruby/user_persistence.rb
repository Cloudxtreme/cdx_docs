
rails generate controller Users new
~~~~~~~~~~~~~~~~~~~~~~~~~~

pg6=# \d+ users
                                                 
       Column       |            Type             
--------------------+-----------------------------
 id                 | integer                     
 created_at         | timestamp without time zone 
 updated_at         | timestamp without time zone 
 name               | character varying(255)      
 email              | character varying(255)      
 encrypted_password | character varying(255)      
 salt               | character varying(255)      

~~~~~~~~~~~~~~~~~~~~~~~~~~
vi user.rb

require 'digest'

class User < ActiveRecord::Base
  attr_accessor :password
  attr_accessible :email, :name, :password, :password_confirmation

  validates :name, :presence => true, :length => {:maximum => 20 }
  validates :email, :presence => true, :format => {:with => /\A[\w+\-.]+@[a-z\d\-.]+\.[a-z]+\z/i }
  validates :password, :presence => true, :confirmation => true, :length => {:within => 6..40 }

  before_save :encrypt_password

  def has_password?(submitted_password)
    encrypted_password == encrypt(submitted_password)
  end

  def self.authenticate(email, submitted_password)
    user = find_by_email(email)
    return nil if user.nil?
    return user if user.has_password?(submitted_password)
  end

  private
    def encrypt_password
      self.salt = make_salt if new_record?
      self.encrypted_password = encrypt(password)
    end

    def encrypt(string)
      secure_hash("#{salt}--#{string}")
    end

    def make_salt
      secure_hash("#{Time.now.utc}--#{password}")
    end

    def secure_hash(string)
      Digest::SHA2.hexdigest(string)
    end

end

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

$ rails console

User.create(:name => 'first last', :email => 'helloworld@cardiodx.com', :password => 'foobar', :password_confirmation => 'foobar')

user = User.find_by_email('helloworld@cardiodx.com')
user.has_password?('foobar')
user.respond_to?(:password)
u = User.authenticate('helloworld@cardiodx.com', 'foobar')


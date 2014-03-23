
http://guides.rubyonrails.org/generators.html
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

rails generate
rails generate helper --help


cd pg1/config/initializers

vi initializer_generator.rb
class InitializerGenerator < Rails::Generators::Base
  desc "This generator creates an initializer file at config/initializers"
  def create_initializer_file
    create_file "config/initializers/initializer.rb", "# Add initialization content here"
  end
end

rails generate initializer --help

rails generate initializer
      create  config/initializers/initializer.rb



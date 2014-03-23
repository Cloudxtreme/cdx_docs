class Admin::Namespace < ActiveRecord::Base
  include ModelHelper

  attr_accessible :created_at, :created_by, :modified_at, :modified_by, :name
	validates :name, :presence => true

  has_many :collections, :dependent => :destroy 

  after_create :create_base_dirs_and_model_file
  after_destroy :delete_base_dirs

	def prefix
		self.name.downcase
	end

  def my_dirs
    controller_dir  = "app/controllers/#{self.prefix}"
    model_dir = "app/models/#{self.prefix}"
    view_dir = "app/views/#{self.prefix}"
    { :controller => controller_dir, :model => model_dir, :view => view_dir }
  end

  def create_base_dirs_and_model_file
    # directories
    self.my_dirs.each_value do |dir|
      unless File.directory?(dir)
        FileUtils.mkdir_p(dir)
      end
    end

    # model profix
    fd = File.open('templates/models/prefix.rb')
    template = fd.read
    fd.close

    renderer = ERB.new(template, nil, '-')
    fd = File.open("app/models/#{self.prefix}.rb", 'w')
    fd.puts renderer.result(binding)
    fd.close

  end

  def delete_base_dirs
    self.my_dirs.each_value do |dir|
      if File.directory?(dir)
        FileUtils.rm_rf(dir)
      end
    end

    FileUtils.rm_f("app/models/#{self.prefix}.rb")
  end

end


class Product < ActiveRecord::Base
  include ActionView::Helpers::TextHelper
  
  attr_accessible :name, :price, :description
  
  def _as_json
    { :id => id, :name => name, :price => price, :description => truncate(description, :length => 28, :omission => '...') }
  end
end

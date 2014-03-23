#
# For testing purpose........
#

# new controller
vi products_controller.rb
class ProductsController < ApplicationController
  def index
  end
end

# new view
mkdir products
touch products/index.html.erb

http://cchoudesktop:3000/products/  ------------> No route error!!

vi routes.rb
  resources :products

http://cchoudesktop:3000/admins/setr/
http://cchoudesktop:3000/admins/getr/


http://cchoudesktop:3000/products/ ------------> Loaded!!




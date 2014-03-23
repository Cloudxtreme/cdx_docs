require 'test_helper'

class Admin::SecuritiesControllerTest < ActionController::TestCase
  setup do
    @admin_security = admin_securities(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:admin_securities)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create admin_security" do
    assert_difference('Admin::Security.count') do
      post :create, admin_security: { name: @admin_security.name }
    end

    assert_redirected_to admin_security_path(assigns(:admin_security))
  end

  test "should show admin_security" do
    get :show, id: @admin_security
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @admin_security
    assert_response :success
  end

  test "should update admin_security" do
    put :update, id: @admin_security, admin_security: { name: @admin_security.name }
    assert_redirected_to admin_security_path(assigns(:admin_security))
  end

  test "should destroy admin_security" do
    assert_difference('Admin::Security.count', -1) do
      delete :destroy, id: @admin_security
    end

    assert_redirected_to admin_securities_path
  end
end

require 'test_helper'

class Admin::FieldsControllerTest < ActionController::TestCase
  setup do
    @admin_field = admin_fields(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:admin_fields)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create admin_field" do
    assert_difference('Admin::Field.count') do
      post :create, admin_field: { created_at: @admin_field.created_at, created_by: @admin_field.created_by, data_type: @admin_field.data_type, label: @admin_field.label, modified_at: @admin_field.modified_at, modified_by: @admin_field.modified_by, name: @admin_field.name }
    end

    assert_redirected_to admin_field_path(assigns(:admin_field))
  end

  test "should show admin_field" do
    get :show, id: @admin_field
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @admin_field
    assert_response :success
  end

  test "should update admin_field" do
    put :update, id: @admin_field, admin_field: { created_at: @admin_field.created_at, created_by: @admin_field.created_by, data_type: @admin_field.data_type, label: @admin_field.label, modified_at: @admin_field.modified_at, modified_by: @admin_field.modified_by, name: @admin_field.name }
    assert_redirected_to admin_field_path(assigns(:admin_field))
  end

  test "should destroy admin_field" do
    assert_difference('Admin::Field.count', -1) do
      delete :destroy, id: @admin_field
    end

    assert_redirected_to admin_fields_path
  end
end

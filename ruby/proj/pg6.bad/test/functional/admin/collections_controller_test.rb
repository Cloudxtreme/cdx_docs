require 'test_helper'

class Admin::CollectionsControllerTest < ActionController::TestCase
  setup do
    @admin_collection = admin_collections(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:admin_collections)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create admin_collection" do
    assert_difference('Admin::Collection.count') do
      post :create, admin_collection: { name: @admin_collection.name }
    end

    assert_redirected_to admin_collection_path(assigns(:admin_collection))
  end

  test "should show admin_collection" do
    get :show, id: @admin_collection
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @admin_collection
    assert_response :success
  end

  test "should update admin_collection" do
    put :update, id: @admin_collection, admin_collection: { name: @admin_collection.name }
    assert_redirected_to admin_collection_path(assigns(:admin_collection))
  end

  test "should destroy admin_collection" do
    assert_difference('Admin::Collection.count', -1) do
      delete :destroy, id: @admin_collection
    end

    assert_redirected_to admin_collections_path
  end
end

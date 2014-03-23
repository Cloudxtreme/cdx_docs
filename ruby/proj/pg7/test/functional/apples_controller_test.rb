require 'test_helper'

class ApplesControllerTest < ActionController::TestCase
  setup do
    @apple = apples(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:apples)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create apple" do
    assert_difference('Apple.count') do
      post :create, apple: { bbl: @apple.bbl, dbin: @apple.dbin, ddate: @apple.ddate, ddec: @apple.ddec, ddt: @apple.ddt, dflt: @apple.dflt, dint: @apple.dint, dstr: @apple.dstr, dtime: @apple.dtime, dtxt: @apple.dtxt }
    end

    assert_redirected_to apple_path(assigns(:apple))
  end

  test "should show apple" do
    get :show, id: @apple
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @apple
    assert_response :success
  end

  test "should update apple" do
    put :update, id: @apple, apple: { bbl: @apple.bbl, dbin: @apple.dbin, ddate: @apple.ddate, ddec: @apple.ddec, ddt: @apple.ddt, dflt: @apple.dflt, dint: @apple.dint, dstr: @apple.dstr, dtime: @apple.dtime, dtxt: @apple.dtxt }
    assert_redirected_to apple_path(assigns(:apple))
  end

  test "should destroy apple" do
    assert_difference('Apple.count', -1) do
      delete :destroy, id: @apple
    end

    assert_redirected_to apples_path
  end
end

require 'test_helper'

class Service::TimecardsControllerTest < ActionController::TestCase
  setup do
    @service_timecard = service_timecards(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:service_timecards)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create service_timecard" do
    assert_difference('Service::Timecard.count') do
      post :create, service_timecard: { name: @service_timecard.name }
    end

    assert_redirected_to service_timecard_path(assigns(:service_timecard))
  end

  test "should show service_timecard" do
    get :show, id: @service_timecard
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @service_timecard
    assert_response :success
  end

  test "should update service_timecard" do
    put :update, id: @service_timecard, service_timecard: { name: @service_timecard.name }
    assert_redirected_to service_timecard_path(assigns(:service_timecard))
  end

  test "should destroy service_timecard" do
    assert_difference('Service::Timecard.count', -1) do
      delete :destroy, id: @service_timecard
    end

    assert_redirected_to service_timecards_path
  end
end

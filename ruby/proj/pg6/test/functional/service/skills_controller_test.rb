require 'test_helper'

class Service::SkillsControllerTest < ActionController::TestCase
  setup do
    @service_skill = service_skills(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:service_skills)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create service_skill" do
    assert_difference('Service::Skill.count') do
      post :create, service_skill: { name: @service_skill.name }
    end

    assert_redirected_to service_skill_path(assigns(:service_skill))
  end

  test "should show service_skill" do
    get :show, id: @service_skill
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @service_skill
    assert_response :success
  end

  test "should update service_skill" do
    put :update, id: @service_skill, service_skill: { name: @service_skill.name }
    assert_redirected_to service_skill_path(assigns(:service_skill))
  end

  test "should destroy service_skill" do
    assert_difference('Service::Skill.count', -1) do
      delete :destroy, id: @service_skill
    end

    assert_redirected_to service_skills_path
  end
end

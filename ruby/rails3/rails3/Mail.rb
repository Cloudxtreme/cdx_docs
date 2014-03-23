

Pony.mail(
	:from 		=> 'abc@cardiodx.com', 
	:to => 'cchou@cardiodx.com', :via => :smtp, 
	:via => :smtp,
	:via_options => { :address => 'smtp.cardiodx.com', :port => '25',},
	:subject => 'test email', 
	:body => 'Hello there.'
)




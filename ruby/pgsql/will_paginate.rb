
https://github.com/mislav/will_paginate
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

$ vi Gemfile
gem 'will_paginate', '~> 3.0'

bundle install

@books = Book.paginate(:page => 1, :per_page => 10)
@books = Book.paginate(:page => 2, :per_page => 10)

@books = Book.paginate(:page => 2, :per_page => 10).order('title DESC')


module <%= self.name %>
  def self.table_name_prefix
    '<%= prefix%>_'
  end
end


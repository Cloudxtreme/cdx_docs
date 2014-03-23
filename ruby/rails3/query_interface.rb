
Admin::Collection.joins(:namespace).where("admin_namespaces.name != 'Admin'")

	SELECT "admin_namespaces".* 
	FROM "admin_namespaces" i
		INNER JOIN "admin_collections" ON "admin_collections"."namespace_id" = "admin_namespaces"."id" 
	WHERE (admin_namespaces.name != 'Admin')

Admin::Namespace.joins(:collections).where("admin_namespaces.name != 'Admin'")

 	SELECT "admin_collections".* 
	FROM "admin_collections" 
		INNER JOIN "admin_namespaces" ON "admin_namespaces"."id" = "admin_collections"."namespace_id" 
	WHERE (admin_namespaces.name != 'Admin')

# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Admin::Collection.joins(:fields).where("admin_collections.name = 'Car'")


Admin::Field.joins(:collection).where("admin_collections.name = 'Car'")


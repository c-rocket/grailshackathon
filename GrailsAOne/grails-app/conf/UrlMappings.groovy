class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?(.$format)?"{ constraints { // apply constraints here
			} }

		"/"(view:"/index")
		"/nav"(view:"/nav")
		"/browse"(view:"/browse")
		"/login"(view:"/login")
		"/nav"(view:"/nav")
		"/register"(view:"/register")
		"/partials/changepass"(view:"/partials/changepass")
		"/partials/edit"(view:"/partials/edit")
		"/partials/offer"(view:"/partials/offer")
		"/partials/post"(view:"/partials/post")
		"500"(view:'/error')

		//ITEMS
		"/items/"(controller: "items", action: "getItems")
		"/item/"(controller: "items"){
			action =[GET:"getItems", POST:"createItem" ]
		}
		"/item/$id"(controller: "items") {
			action = [GET: "getItem", PUT: "updateItem", DELETE: "deleteItem"]
		}

		//USERS
		"/userpass"(controller: "users"){
			action =[POST:"changePassword"]
		}
		"/user"(controller: "users"){
			action =[POST:"createUser"]
		}
		"/login/$email/$password"(controller: "users"){
			action =[GET:"login"]
		}

		//COMMENTS
		"/comment/$itemId"(controller: "comments", action: "getComments")
		"/newComment"(controller: "comments"){
			action =[GET:"newComment"]
		}

		//OFFERS
		"/offer/$id"(controller: "offers"){
			action =[GET:"getOffers", PUT: "updateOffer" ]
		}
		"/newOffer"(controller: "offers"){
			action =[GET:"newOffer"]
		}
	}
}

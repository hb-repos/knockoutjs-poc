mainContentViewModel=function(){
	
	var self=this;
	self.books=ko.observableArray();
	
	$.getJSON("http://localhost:8081").then(function(books){
		$.each(books, function(){
			self.books.push({
				title: ko.observable(this.title),
				author: ko.observable(this.author)
			});
		});
	});
	
	//removeBook
	
	self.removeBook=function(book){
		self.books.remove(book);
	}
	
};

ko.applyBindings(new mainContentViewModel());
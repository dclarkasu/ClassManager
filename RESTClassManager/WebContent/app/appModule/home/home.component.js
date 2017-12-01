angular.module('appModule').component('home', {
	templateURL: 'app/appModule/home/home.component.html',
	controller: function(classService) {
		
		var vm = this;
		
		vm.classes = [];
		
		vm.loadClassesByUser = function() {
			console.log("home classes call");
			classService.indexUserClasses()
			.then(function(res) {
				vm.classes = res.data;
				console.log(res);
				console.log(vm.classes);
			})
		};
		
		vm.loadClassesByUser();
	},
	controllerAs: 'vm'
});
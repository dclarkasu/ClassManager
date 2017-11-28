angular.module('appModule')
.component('navbar',{
	templateUrl: 'app/appModule/navbar/navbar.component.html',
	controller: function($cookies, classService, $scope){

		var vm = this;

		vm.classes = [];

		//Behaviors


//		vm.getUserId = function(){
//			return $cookies.get('userId');
//		};

//		vm.isLoggedIn = function(){
//			if($cookies.get('userId')){
//				return true
//			}
//			return false;
//		};

		vm.loadClassesByUser = function() {
			classService.indexUserClasses()
			.then(function(res) {
				vm.classes = res.data;
			})
		};

		vm.loadClassesByUser();
		
//		$scope.$on('createdGroup', function(ev, data) {
//			vm.loadGroupsByUser();
//		})
//
//		$scope.$on('getUserGroups', function(ev, data) {
//			vm.groups = data.groups;
//		})
//
//		$scope.$on('updatedGroup', function(ev, data) {
//			vm.groups.forEach(function(val, idx, arr) {
//				if (val.id === data.group.id) {
//					console.log("FOUND");
//					arr[idx] = data.group;
//				}
//			})
//		})
//
//		$scope.$on('deleteGroup', function(ev, data) {
//			vm.groups.forEach(function(val, idx, arr) {
//				if (val.id === data.groupID) {
//					arr.splice(idx, 1);
//				}
//			})
//		})

	},
	controllerAs: 'vm'
});

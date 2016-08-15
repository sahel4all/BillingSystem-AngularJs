/**
 * For lazy people.
 * Reference / Origin:
 * http://stackoverflow.com/questions/24883308/convert-birthday-to-age-in-angularjs
 */
+function(angular, undefined) {
  'use strict';
  angular
    .module('srph.age-filter', [])
    .filter('age', age);

  function age() {
    return function(input, current) {
      // Difference in milliseconds
      current = Date.parse(current) || Date.now();
      var ageDiff =  current - new Date(input).getTime();
      var ageDate = new Date(ageDiff);

      return Math.abs( ageDate.getUTCFullYear() - 1970 );
    }
  }
}(angular);
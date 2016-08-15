# angular-age-filter

An angular filter that converts date to age <del>for lazy people</del>.

## Getting Started

Should work with AngularJS ```>=1.2.0```.

### Installation

...

### Usage

Templates

```html
{{ '11/23/1996' | age }}
{{ 848678400000 | age }}
```

Controller, directives, etc..

```js
app.controller('YoloController', function($scope, $filter) {
	$scope.myDate = $filter('age')('11/23/1996');
	$scope.hisDate = $filter('age')(848678400000);
})
```

## Acknowlegement

This isn't my work. You might want to check the [SO Answer](http://stackoverflow.com/questions/24883308/convert-birthday-to-age-in-angularjs) by [pixelbits](http://stackoverflow.com/users/3661630/pixelbits).

> [srph.github.io](http://srph.github.io) &nbsp;&middot;&nbsp;
> GitHub [@srph](https://github.com/srph) &nbsp;&middot;&nbsp;
> Twitter [@_srph](https://twitter.com/_srph)
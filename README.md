# Cordova Android Preserve State Plugin

A simple cordova plugin to access android saveInstanceState, and restore application state when cleared from ram.

This plugin is useful for storing information that needs to persist while the app is open, regardless of if it's activity has been stopped. The state string will only cleared when the app is *closed*.
    
## Installation

    $ cordova plugin add https://github.com/terpro/cordova-plugin-preserve-state.git

## Usage
	
preservestate.getState and preservestate.setState availible after `onDeviceReady`

### preservestate.getState

```js
preservestate.getState(successCallback, errorCallback);
```

#### Parameters

**successCallback:** *(function)* Will return previously stored state string (or "#" if undefined)

**errorCallback:** *(function)* I don't imagine you'll get any errors.. but just in case

### preservestate.setState

```js
preservestate.setState(stateString, successCallback, errorCallback);
```

#### Parameters

**stateString:** *(string)* A string containing everything you need to remember where you are in the app (for my use case, the current hash) 

**successCallback:** *(function)* Will return state string (the same one you just set)

**errorCallback:** *(function)* I don't imagine you'll get any errors.. but just in case

## Example code

### Set hash from previously stored state

```js
document.addEventListener("deviceready", function() {
		
	preservestate.getState(function(state) {
		
		location.hash = state;
		
	})
		
}, false);
```

### Store current state

```js
preservestate.setState(location.hash)
```

# Cordova Android Preserve State Plugin

(Android only) A simple cordova plugin to access android saveInstanceState, and restore application state when cleared from ram.

This plugin is useful for storing information that needs to persist while the app is open, regardless of if it's activity has been stopped. The state string will only cleared when the app is *closed*.
    
## Installation

    $ cordova plugin add https://github.com/terreng/cordova-plugin-preserve-state.git
    
But wait, **theres more!**

### You'll also need to make some changes to CordovaActivity.java

This file can be found at platforms\android\CordovaLib\src\org\apache\cordova\cordovaActivity.java

Add the following on **line 115** inside of the onCreate function (right after `loadConfig();`):

```java
String saved_hash = "#";

if (savedInstanceState != null) {
	saved_hash = savedInstanceState.getString("SAVED_HASH");
}

preferences.set("saved_hash", saved_hash);
```

And then add the following on the now **line 501** in the onSaveInstanceState function (right before `super.onSaveInstanceState(outState);`):

```java
outState.putString("SAVED_HASH", preferences.getString("saved_hash", "#"));
```

I've also uploaded an example file with all of the changes I just described made: https://github.com/terreng/cordova-plugin-preserve-state/blob/master/CordovaActivity.java

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

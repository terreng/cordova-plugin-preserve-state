# Cordova Android Preserve State Plugin

A simple cordova plugin to access android saveInstanceState, and restore application state when cleared from ram
    
## Installation

    $ cordova plugin add https://github.com/terpro/cordova-plugin-preserve-state.git

## Usage
	
preservestate.getState and preservestate.setState availible after `onDeviceReady`

### preservestate.getState

```js
    preservestate.getState(successCallback, errorCallback);
```

#### Parameters

**successCallback:** *(function)* Will return state string

**errorCallback:** *(function)* I don't imagine you'll get any errors.. but just in case

### preservestate.setState

```js
    preservestate.setState(stateString, successCallback, errorCallback);
```

#### Parameters

**stateString:** *(string)* A string containing everything you need to remember where you are in the app (for my use case, the current hash) 

**successCallback:** *(function)* Will return state string (the same one you just set)

**errorCallback:** *(function)* I don't imagine you'll get any errors.. but just in case

### Example code

```js

```


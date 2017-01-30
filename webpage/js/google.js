/** Google Calendar API Code **/
// Client ID and API key from the Developer Console
var CLIENT_ID = '763720848299-of8hnj9f4f9bi3a6b5fq83aaof2v5cdo.apps.googleusercontent.com';

// Array of API discovery doc URLs for APIs used by the quickstart
var DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest"];

// Authorization scopes required by the API; multiple scopes can be
// included, separated by spaces.
var SCOPES = "https://www.googleapis.com/auth/calendar.readonly";

var authorize = document.getElementById('authorize');
var signout = document.getElementById('signout');



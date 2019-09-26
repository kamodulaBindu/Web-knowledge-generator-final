// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  // for local use 
  // loginURL: "http://172.23.238.220:9090",
  // aws vm ip
  loginURL: "http://13.233.25.37:9090",

  // for local use 
  // populationURL: "http://172.23.238.226:8402/api/v1/save",
  // aws vm ip
  populationURL:"http://13.233.25.37:8402/api/v1/save",

  // for local use
  //notificationURL: "http://localhost:8404/ws"
  // aws vm ip
  notificationURL:"http://13.233.25.37:8404/ws"


};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.

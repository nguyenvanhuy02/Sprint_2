// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  api_url: 'http://localhost:8080/ccdc',
  api_url_them: 'http://localhost:8080/ccdc/them',
  api_url_detail: 'http://localhost:8080/ccdc/detail/',
  api_url_muon: 'http://localhost:8080/ccdc/muonccdc/',
  api_url_nhanvien: 'http://localhost:8080/ccdc/nhanvien/',
  api_url_quanly: 'http://localhost:8080/ccdc/quanly/',
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.

/* eslint-env worker */
(global => {
  'use strict';

  var toolbox;
  var importScripts = importScripts || function () {};
  importScripts('../node_modules/sw-toolbox/sw-toolbox.js');
  global.addEventListener('install', event => event.waitUntil(global.skipWaiting()));
  global.addEventListener('activate', event => event.waitUntil(global.clients.claim()));

  if (typeof toolbox === 'undefined') {
    return;
  }

  toolbox.router.get('/(.*)', global.toolbox.cacheFirst, {
    cache: {
      name: 'googleapis',
      maxEntries: 10,
      maxAgeSeconds: 86400
    },
    origin: /\.googleapis\.com$/
  });
})(self);

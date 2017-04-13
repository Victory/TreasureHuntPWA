'use strict';

import gulp from 'gulp';
import postcss from 'gulp-postcss';
import del from 'del';
import shell from 'gulp-shell';

gulp.task('css', function() {
  var postcss = require('gulp-postcss');
  var sourcemaps = require('gulp-sourcemaps');

  return gulp.src('src/**/*.css')
    .pipe(sourcemaps.init())
    .pipe(postcss([require('precss'), require('autoprefixer')]))
    .pipe(sourcemaps.write('.'))
    .pipe(gulp.dest('build/'));
});

gulp.task('upgrade', shell.task([
  "yarn"
]));

gulp.task('dev', shell.task([
  "yarn run dev"
]));

gulp.task('builddist', ['clean'], shell.task([
  "yarn run build"
]));

gulp.task('unit', shell.task([
  "yarn run unit"
]));

gulp.task('generate-service-worker', function(callback) {
  var path = require('path');
  var swPrecache = require('sw-precache');
  var rootDir = 'dist';

  swPrecache.write(`${rootDir}/service-worker.js`, {
    staticFileGlobs: [rootDir + '/**/*.{js,html,css,png,jpg,gif,svg,eot,ttf,woff}'],
    stripPrefix: rootDir
  }, callback);
});

gulp.task('clean', () => del(['.tmp', 'dist/*', '!dist/.git'], {
  dot: true
}));

gulp.task('build', ['builddist', 'generate-service-worker']);

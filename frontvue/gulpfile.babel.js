'use strict';

import gulp from 'gulp';
import shell from 'gulp-shell';

gulp.task('dev', shell.task([
  "npm run dev"
]));

gulp.task('build', shell.task([
  "npm run build"
]));

gulp.task('unit', shell.task([
  "npm run unit"
]));

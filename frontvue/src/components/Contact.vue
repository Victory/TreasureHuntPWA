<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <router-link v-bind:to="{name: 'home'}">Go Home</router-link>
  </div>
</template>

<script>
import store from '../store/index';

export default {
  name: 'contact',
  beforeMount () {
    store.state.pagesVisited += 1;
  },
  data () {
    return {
      msg: 'This is the CONTACT page'
    }
  }
}
</script>

<style scoped>

</style>

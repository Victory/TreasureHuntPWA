<template>
  <div id="app">
    <img src="./assets/logo.png">
    <router-view></router-view>
    <main-nav></main-nav>
  </div>
</template>

<script>
  import MainNav from '@/components/MainNav'

  export default {
    name: 'app',
    components: {
      MainNav
    }
  }
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

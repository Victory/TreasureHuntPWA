<template>
  <div>
    <h4>My Set Nav</h4>
    <ul>
      <li><router-link :to="{name: 'home'}">Home</router-link></li>
      <li><router-link :to="{name: 'contact'}">Contact US</router-link></li>
      <li><router-link :to="{name: 'about'}">About</router-link></li>
      <li><router-link :to="{name: 'privacy'}">Privacy</router-link></li>
      <li><router-link :to="{name: 'login'}">Login</router-link></li>
    </ul>
    <p>Pages Visited: {{ $store.state.pagesVisited }}</p>
  </div>
</template>

<script>
  export default {
    name: 'main-nav'
  }
</script>

<style scoped="">
</style>

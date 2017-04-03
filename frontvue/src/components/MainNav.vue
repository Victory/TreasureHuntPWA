<template>
  <div>
    <h4>My Seet Nav</h4>
    <ul>
      <li><router-link :to="{name: 'home'}">Home</router-link></li>
      <li><router-link :to="{name: 'contact'}">Contact US</router-link></li>
      <li><router-link :to="{name: 'about'}">About</router-link></li>
      <li><router-link :to="{name: 'privacy'}">Privacy</router-link></li>
    </ul>
  </div>
</template>

<script>
  export default {
    name: 'main-nav'
  }
</script>

<style scoped="">
</style>

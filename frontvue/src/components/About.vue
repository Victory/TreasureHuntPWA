<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <router-link v-bind:to="{name: 'home'}">Go Home</router-link>
  </div>
</template>

<script>
export default {
  name: 'about',
  data () {
    return {
      msg: 'This is the about page'
    }
  }
}
</script>

<style scoped>

</style>

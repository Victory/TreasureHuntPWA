<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <router-link v-bind:to="{name: 'home'}">Go Home</router-link>
  </div>
</template>

<script>
export default {
  name: 'privacy',
  data () {
    return {
      msg: 'This is the privacy page'
    }
  }
}
</script>

<style scoped>

</style>

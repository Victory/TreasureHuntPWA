<template>
  <div class="homemsg">
    {{ msg }}
    <router-link to="contact">Contact US</router-link>
  </div>
</template>

<script>
export default {
  name: 'home',
  data () {
    return {
      msg: 'This is the homepage!'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .homemsg {
    color: rebeccapurple;
  }
</style>

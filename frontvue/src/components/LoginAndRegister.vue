<template>
  <div id="login-and-register">
    <login></login>
    <register></register>
  </div>
</template>

<script>
import Login from '@/components/Login'
import Register from '@/components/Register'
export default {
  name: 'login-and-register',
  components: {
    Login,
    Register
  }
}
</script>

<style scoped>
</style>

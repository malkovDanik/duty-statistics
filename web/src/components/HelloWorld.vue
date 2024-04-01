<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <p>
      Тут будет приложение
    </p>
    <button @click="onClick">Жмякни!</button>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  props: {
    msg: String
  },
  mounted() {
    //todo хук создания приложения
  },
  methods: {
    onClick() {
      fetch('/test', {
        headers: {
          'Content-Type': 'application/json',
          Accept: 'application/json',
        },
      })
          .then(async response => response.text()) // для получения json используйте response.json()
          .then(data => alert(data + '\nХватит жмякать!'))
          .catch((error) => alert(error));
    },
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>

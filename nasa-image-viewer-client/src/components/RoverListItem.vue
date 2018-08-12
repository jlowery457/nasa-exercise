<template>
  <el-submenu :index="rover.id">
    <template slot="title">
      <span>{{rover.name}}</span>
    </template>
    <DateList :dates="dates" :rover="rover"/>
  </el-submenu>
</template>
<script>
  import DateList from './DateList';
  export default {
    components: {
      DateList
    },
    props: {
      rover: {
        required: true,
        type: Object
      },
      dates: {
        required: true,
        type: Array
      }
    }
  }
</script>

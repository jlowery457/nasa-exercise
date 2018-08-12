<template>
  <el-menu-item
    :index="index"
    @click="click(rover.name, date)"
  >
    {{date}}
  </el-menu-item>
</template>
<script>
  import { EventBus } from '../services/EventBus';
  export default {
    props: {
      date: {
        required: true,
        type: String
      },
      index: {
        required: true,
        type: String
      },
      rover: {
        required: true,
        type: Object
      }
    },
    methods: {
      click(name, date) {
        EventBus.$emit('date-clicked', {
          name: name,
          date: date
        });
      }
    }
  }
</script>

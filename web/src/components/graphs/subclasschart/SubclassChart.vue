<template>
    <div class="chart-container">
        <div :id="containerId" class="chart"></div>
    </div>
</template>

<script lang="ts" src="./SubclassChart.ts" />

<style lang="scss" scoped>
.chart-container {
    height: 100%;
    width: 100%;
    display: block;
}
.chart {
    height: 100%;
    width: 100%;
    ::v-deep {
        .anychart-credits {
            display: none;
        }
    }
}
</style>

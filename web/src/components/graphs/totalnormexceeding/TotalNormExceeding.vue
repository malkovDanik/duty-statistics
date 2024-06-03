<template>
    <div class="chart-container">
        <span style="font-size: 13px; color: #303133;"
            >Перерасход полного технического ресурса двигателя
        </span>
        <div :id="containerId" class="chart"></div>
    </div>
</template>

<script lang="ts" src="./TotalNormExceeding.ts" />

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

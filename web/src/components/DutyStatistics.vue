<template>
    <div>
        <section-top-panel />
        <div class="central-panel">
            <div style="display: flex; align-items: center">
                <span class="field-label">Период: </span>
                <el-date-picker
                    v-model="period"
                    format="dd.MM.yyyy HH:mm"
                    align="center"
                    end-placeholder="Дата окончания"
                    range-separator="по"
                    start-placeholder="Дата начала"
                    type="datetimerange"
                    unlink-panels
                    class="change-log-date-picker"
                    size="mini"
                    :picker-options="pickerOptions"
                    :clearable="false"
                    @change="changePeriod"
                >
                </el-date-picker>
                <div
                    v-if="selectedShip"
                    class="field-label"
                    style="margin-left: 200px"
                >
                    <span>Наплаванность судна: </span>
                    <span>{{ swimming }}</span>
                </div>
            </div>
            <div style="display: flex; flex: 0.8; margin-top: 10px">
                <ships-table :ships="ships" @selectShip="selectShip" />
                <route-table
                    :selectedShip="selectedShip"
                    :routes="routes"
                    style="margin-left: 10px"
                />
                <subclass-chart
                    :chartData="subclassChart"
                    style="margin-left: 10px"
                />
            </div>
            <graphs :period="period" style="flex: 1.2; margin-top: 10px" />
        </div>
    </div>
</template>

<script src="./DutyStatistics.ts" lang="ts"></script>

<style lang="scss" scoped>
.field-label {
    font-size: 14px;
    color: #5b5b5b;
    margin-right: 10px;
}
.central-panel {
    display: flex;
    flex-direction: column;
    box-sizing: border-box;
    height: calc(100% - 40px);
    padding: 7px;
}
::v-deep {
    .el-table .cell {
        line-height: 24px;
        font-size: 13px;
    }
    .el-table td {
        padding: 0;
    }
    .el-card__body {
        padding: 5px 10px;
    }
}
</style>

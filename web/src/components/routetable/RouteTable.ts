import { Component, Prop, Vue } from 'vue-property-decorator';

@Component
export default class RouteTable extends Vue {
    @Prop({ default: (): [] => [] })
    private routes!: any[];

    public distanceToMiles(distanceInKilometer: number): number {
        return distanceInKilometer * 0.539957;
    }
}

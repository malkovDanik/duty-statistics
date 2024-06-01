import {
    AxiosInstance,
    AxiosPromise,
    AxiosRequestConfig,
    CancelTokenSource,
} from 'axios';
import { axiosFactory } from '@/api/AxiosFactory';

export abstract class AbstractApi {
    public constructor() {
        this.axiosInstance = axiosFactory.axiosInstance;
    }

    public mainUrl: string = ''; // Основная часть урлы для АПИ

    private axiosInstance!: AxiosInstance;

    protected cancelTokenRequests: {
        [key: string]: /*урла*/ CancelTokenSource;
    } = {};

    /**
     * GET-запрос
     * @param additionalUrl урл
     * @param config конфиг
     * @protected
     */
    protected get(
        additionalUrl: string = '',
        config?: AxiosRequestConfig
    ): AxiosPromise {
        const fullUrl = this.getFullUrl(additionalUrl);
        if (config) {
            const cancelTokenSource = axiosFactory.createCancelTokenSource();
            this.cancelTokenRequests[fullUrl] = cancelTokenSource;
            config.cancelToken = cancelTokenSource.token;
        } else {
            // добавить для геттеров у которых нет параметров. Тогда канселы будут создавться для всех. Надо проверять работоспособность.
        }
        return this.axiosInstance.get(fullUrl, config);
    }

    /**
     * Геттер у которого много параметров
     * @param additionalUrl урл
     * @param data тело запроса
     * @param config конфиг
     * @protected
     */
    protected getAsPost(
        additionalUrl: string = '',
        data?: object | null,
        config?: AxiosRequestConfig
    ): AxiosPromise {
        const fullUrl = this.getFullUrl(additionalUrl);
        const cancelTokenSource = axiosFactory.createCancelTokenSource();
        this.cancelTokenRequests[fullUrl] = cancelTokenSource;
        if (config) {
            config.cancelToken = cancelTokenSource.token;
        } else {
            config = { cancelToken: cancelTokenSource.token };
        }
        return this.axiosInstance.post(fullUrl, data, config);
    }

    /**
     * PUT-запрос
     * @param additionalUrl урл
     * @param data тело запроса
     * @param config конфиг
     * @protected
     */
    protected put(
        additionalUrl: string = '',
        data?: object | null,
        config?: AxiosRequestConfig
    ): AxiosPromise {
        return this.axiosInstance.put(
            this.getFullUrl(additionalUrl),
            data,
            config
        );
    }

    /**
     * POST-запрос
     * @param additionalUrl урл
     * @param data тело запроса
     * @param config конфиг
     * @protected
     */
    protected post(
        additionalUrl: string = '',
        data?: object | null,
        config?: AxiosRequestConfig
    ): AxiosPromise {
        const fullUrl = this.getFullUrl(additionalUrl);
        return this.axiosInstance.post(fullUrl, data, config);
    }

    /**
     * DELETE-запрос
     * @param additionalUrl урл
     * @param config конфиг
     * @protected
     */
    protected delete(
        additionalUrl: string = '',
        config?: AxiosRequestConfig
    ): AxiosPromise {
        return this.axiosInstance.delete(
            this.getFullUrl(additionalUrl),
            config
        );
    }

    /**
     * Получить полный урл
     * @param additionalUrl дополнительный урл
     * @private
     */
    private getFullUrl(additionalUrl: string): string {
        return this.mainUrl + additionalUrl;
    }

    /**
     * Отменить запросы к серверу
     * @param requestUrls - урлы запросов
     */
    protected cancelGetRequests(requestUrls: string[]): void {
        for (const requestUrl of requestUrls) {
            this.cancelRequest(requestUrl);
        }
    }
    /**
     * Отменить запрос к серверу
     * @param requestUrl - урл запроса
     */
    protected cancelRequest(requestUrl: string): void {
        const fullUrl = this.getFullUrl(requestUrl);
        const cancelTokenRequest = this.cancelTokenRequests[fullUrl];
        if (cancelTokenRequest) {
            // eslint-disable-next-line no-console
            console.log('Запрос ' + requestUrl + ' отменен!');
            cancelTokenRequest.cancel();
        }
    }
}

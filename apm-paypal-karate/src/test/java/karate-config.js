function fn() {
    var env = karate.env; // get system property 'karate.env'

    karate.log('karate.env system property was:', env);
    if (!env) {
        env = 'try';
    }
    var config = {
        apiUrl: 'https://conduit.productionready.io/api/',

    }

    if (env == 'dev') {
        config.apiUrl = 'https://npe.access.worldpay.com/'
        //config.username = 'zes5xs2wzwi7njhe'
        config.username = karate.properties['username'] || 'zes5xs2wzwi7njhe'
        karate.log('**************', karate.properties['username'])
        config.password =  karate.properties['password'] || '4dyqNzo3alz2xRqiFRkj'
         //password = password
        //config.password = '4dyqNzo3alz2xRqiFRkj'

    }
    if (env == 'qa') {
        config.apiUrl = 'https://preprod.access.worldpay.com/'
        config.username = '2o8epttj3ut447c9'
        config.password = 'QgdU3om9mRvlVz2aGYDC'
    }
    if (env == 'local') {
        config.apiUrl = 'http://localhost:8082/'
    }
    if (env == 'try') {
        config.apiUrl = 'https://try.access.worldpay.com/'
        config.username = 'rl2ma6st1tyqmv6c'
        config.password = 'gxhqess4dofbubj80i25g5kvlb6qvkwilg4zjegz22l7f3rft5b8vmrtfhtw0wq0'
    }
    //karate.callSingle('calsspath:klarna/Features/AuthFlow.feature',config)
    karate.configure('headers', { Accept: 'application/vnd.worldpay.paypal-v1+json', 'Content-Type': 'application/vnd.worldpay.paypal-v1+json','wp-correlationId': 'test' });
    karate.configure('retry', { count: 10, interval: 5000 });
    config.faker = Java.type('com.github.javafaker.Faker');


    return config;
}
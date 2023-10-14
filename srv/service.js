//const cds = require('@sap/cds') 

module.exports = class dev  extends cds.ApplicationService { 
    init() { 

        const { Question } = this.entities;

        this.on('assignQuestionsToTest', async req =>{
            let result = 0;
            const testID = req.params[0].ID;
            const questionsCount = req.data.questionsCount;
            //const a =  await SELECT.from(Question);
            if (questionsCount > 0){
                const unboundQuestions = await SELECT.from(Question).where({test_ID : null}).limit(questionsCount);
                for(let question of unboundQuestions){
                    result += cds.run(await UPDATE(Question, question.ID).set({test_ID : testID}));
                }
                const debug=1;
            }
            else { return req.reject('Error. Not available')}

            let resultMessage = result + ' questions were assigned to the test!';
            if (result < questionsCount){
                resultMessage += 'Remain some.'
            }
            req.notify(resultMessage);
            return result;
        })

        // this.before('READ', 'Question', req =>{
        //     console.log('1');
        // })

        return super.init() 
    } 
}
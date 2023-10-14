using schema from '../db/schema';

service dev {
    entity Test as projection on schema.Test 
                actions {
                        //@cds.odata.bindingparameter.name : 'Test'
                        @Common.SideEffects : {
                            TargetProperties : ['questions']
                        } 
                        action assignQuestionsToTest(questionsCount:Integer) returns String;
                    };
    entity Question as projection on schema.Question;
}
annotate dev.Test with @odata.draft.enabled;


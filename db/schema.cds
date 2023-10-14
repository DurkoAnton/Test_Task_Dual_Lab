using { cuid, managed} from '@sap/cds/common';

namespace schema;

entity Test : cuid, managed {
    title : String(30);
    description : String;
    questions : Composition of many Question on questions.test = $self;
}

entity Question : cuid {
    text : String;
    test : Association to Test;
    ans : Composition of one Answer;
}

aspect Answer {
    answerID : UUID;
    text : String;
}
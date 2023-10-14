using dev as service from '../../srv/service';

annotate service.Test with @(
    UI.LineItem : [
        {
            $Type : 'UI.DataField',
            Label : 'title',
            Value : title,
        },
        {
            $Type : 'UI.DataField',
            Label : 'description',
            Value : description,
        },
        {
            $Type : 'UI.DataField',
            Label : 'created at',
            Value : createdAt,
        },
        {
            $Type : 'UI.DataField',
            Label : 'created by',
            Value : createdBy,
        },
    ]
);
annotate service.Test with @(
    UI.FieldGroup #GeneratedGroup1 : {
        $Type : 'UI.FieldGroupType',
        Data : [
            {
                $Type : 'UI.DataField',
                Label : 'title',
                Value : title,
            },
            {
                $Type : 'UI.DataField',
                Label : 'description',
                Value : description,
            },
            {
                $Type : 'UI.DataField',
                Label : 'created at',
                Value : created,
            },
           
        ],
    },
    UI.Facets : [
        {
            $Type : 'UI.ReferenceFacet',
            ID : 'GeneratedFacet1',
            Label : 'General Information',
            Target : '@UI.FieldGroup#GeneratedGroup1',
        },
        {
            $Type : 'UI.ReferenceFacet',
            ID : 'Questions',
            Label : 'Questions',
            Target : 'questions/@UI.LineItem#Questions',
        },
    ],
    UI.Identification : [
    {
        $Type : 'UI.DataFieldForAction',
        Label : 'Add questions',
        Action : 'dev.assignQuestionsToTest',
    }
]
);

annotate service.Question with @(
    UI.LineItem #Questions : [
        {
            $Type : 'UI.DataField',
            Label : 'text',
            Value : text,
        },
        {
            $Type : 'UI.DataField',
            Label : 'test',
            Value : test_ID,
        },
        {
            $Type : 'UI.DataField',
            Label : 'test text',
            Value : test.title,
        },
    ]
);


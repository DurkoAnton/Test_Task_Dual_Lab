sap.ui.require(
    [
        'sap/fe/test/JourneyRunner',
        'fiori/test/integration/FirstJourney',
		'fiori/test/integration/pages/TestList',
		'fiori/test/integration/pages/TestObjectPage'
    ],
    function(JourneyRunner, opaJourney, TestList, TestObjectPage) {
        'use strict';
        var JourneyRunner = new JourneyRunner({
            // start index.html in web folder
            launchUrl: sap.ui.require.toUrl('fiori') + '/index.html'
        });

       
        JourneyRunner.run(
            {
                pages: { 
					onTheTestList: TestList,
					onTheTestObjectPage: TestObjectPage
                }
            },
            opaJourney.run
        );
    }
);
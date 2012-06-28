//
//  AppDelegate.m
//  AOC_project1
//
//  Created by Joel Betterly on 6/28/12.
//  Copyright (c) 2012 Full Sail. All rights reserved.
//

#import "AppDelegate.h"

@implementation AppDelegate

@synthesize window = _window;

- (void)dealloc
{
    [_window release];
    [super dealloc];
}

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
    self.window = [[[UIWindow alloc] initWithFrame:[[UIScreen mainScreen] bounds]] autorelease];
    // Override point for customization after application launch.
    self.window.backgroundColor = [UIColor whiteColor];
    [self.window makeKeyAndVisible];
    
    /* ######## Step 1 Create a New Empty Application Project */

    /* STORY  
     
     I wanted to go out to eat dinner and I needed to decide which restaurant I wanted to go to eat.  I had the choice of Chopsticks (an Asian Buffet), Sweet Tomatoes (All you can eat veggie place), or Arigato’s (Japanese Steak House).
     Since my fundage is a bit weak now, I decided that the steakhouse was out.  I also did not want to drive an hour to get dinner, so I needed to choose something close to home.  Although Sweet Tomatoes is cheap, I did not feel like eating many veggies and it is the furthest from where I live.  I was kind of in the mood for some sushi, Chopsticks was the correct fit, cheap, they are five minutes away, and they have a great variety of sushi.
     It was really good and I ate a bunch of makki rolls and raw tuna, which is my favorite.
     
     
     List
     •	I want to eat dinner out.
     •	Three choices to choose from, Arigato’s, Chopsticks, or Sweet Tomatoes
     •	Decision is based on two factors combined, price and location.
     •	Arigato’s is close but cost is $$$.
     •	Sweet Tomatoes is furthest but cost is $
     •	Chopsticks is close and cost is $$
     •	Chopsticks is best answer with added bonus of sushi.
     
    */
    
    
    
    /* ######## Step 2: Create a variable using the float data type.  Cast the float to an int and using NSLog, output the intial float value as well as the int value. */
    
    float dinnerCostSweetTomatoes = 11.56f;  /* cost of dinner at cheap restaurant */
    float dinnerCostChopsticks = 16.95f;     /* Cost of dinner at medium restaurant */
    float dinnerCostArigatos = 29.95f;       /* Cost of dinner at expensive restaurant */
    int maxDinnerCost = 20.00;               /* The maximum allowed for dinner. */
    
    /* Cast float to int and output to NSLOG */
    int newCostST = (int)dinnerCostSweetTomatoes;
    NSLog(@"The cost to eat at Sweet Tomatoes is around %d dollars.", newCostST);
    
    /* Output the inital float value as well as the int value. */
    NSLog(@"The cost of eating at Sweet Tomatoes is around %d dollars. The exact cost is exactly $%.2f.", newCostST, dinnerCostSweetTomatoes);
    
    
    
    
    
    /* #########  Step 3: Perform an AND, OR comparison.  Use float, int and BOOL types.  BOOL values should be YES or NO and written in all caps. */
    
    int distanceToST = 2;
    int distanceToC = 3;
    int distanceToA = 1;
    bool cleanPlace = TRUE;
    bool dirtyPlace = FALSE;
    
    if ((distanceToST == 2) || (dinnerCostSweetTomatoes <= 12))  /* int and float type witb OR operator */
        {
            NSLog(@"Since the distance is %d miles or the meal is less than $%.2f , Sweet Tomatoes is the best option.", distanceToST, dinnerCostSweetTomatoes);
        }
    else
        {
            NSLog(@"I don't want to drive that far or pay that much for dinner. ");
        }
    
    if ((dirtyPlace == TRUE) && (distanceToC < 2)) /* Boolean and int with AND operator */
        {
            NSLog(@"Chopsticks still hasn't cleaned the place up and we should go some place else.");
        }
    else
        {
            NSLog(@"Chopsticks was really clean the last time I ate there.  Also Chopsticks is %d miles away.", distanceToC);
        }
    
    
    
    /* #########  Step 4: Use an if, else if and else check using any of the data types of your choice. */
    
    if ((dirtyPlace == TRUE) && (dinnerCostArigatos >30))           /* Start with if statement. */
        {
            NSLog(@"Arigato's still has that dirty bird in the restaurant.  Plus they charge more than $30 for a meal.  I don't want to eat here.");
        }
    else if ((cleanPlace == TRUE) && (dinnerCostArigatos == 30))    /* Add if else statement. */
        {
            NSLog(@"Arigato's has removed the bird so the place is clean, but the cost is still too much. Let's find some place else.");
        }
    else                                                            /* End with else statement. */
        {
            NSLog(@"Arigato's has removed the bird and they are having a dinner special of $%.2f, let's eat there tonight.", dinnerCostArigatos);
        }    
    
    
    
    /* #########  Step 5: Perform a single loop printing out values to the console.
       #########  Step 6: Perform a nested loop printing out values to the console. 
       #########  Step 7: Perform a while loop that increments an int variable and outputs to the console.    Combined these together to make it more simple.*/
    
    NSMutableArray *restaurants = [NSMutableArray arrayWithObjects:@"Sweet Tomatoes", @"Chopsticks", @"Arigato's", @"McDonald's", nil]; /* Create array for output. */
    
    for (int i=0; i<3; i++)     /* for loop counts items in array. */
    {
        int r = i +1;
        int stop = r;           /* Create a stop so it won't infinite loop.  */
        NSLog(@"We can eat at: %@", [restaurants objectAtIndex:i]); /* Outputs names of restaurants but does not list Mcdonald's. */
        
        while (stop == 3) /* Start the while loop and checks for 4th restaurant. */
        {
            NSLog(@"No one wants to ever eat at McDonald's.");
            for (int j=3; j<4; j++) /* Nested loop */
                
            {
                NSLog(@"%@ is the worst place to eat.", [restaurants objectAtIndex:j]);
            }
            stop++;  /* Stop the loop and breaks out of loop.*/
        }
    }
    
    
    return YES;
}

- (void)applicationWillResignActive:(UIApplication *)application
{
    // Sent when the application is about to move from active to inactive state. This can occur for certain types of temporary interruptions (such as an incoming phone call or SMS message) or when the user quits the application and it begins the transition to the background state.
    // Use this method to pause ongoing tasks, disable timers, and throttle down OpenGL ES frame rates. Games should use this method to pause the game.
}

- (void)applicationDidEnterBackground:(UIApplication *)application
{
    // Use this method to release shared resources, save user data, invalidate timers, and store enough application state information to restore your application to its current state in case it is terminated later. 
    // If your application supports background execution, this method is called instead of applicationWillTerminate: when the user quits.
}

- (void)applicationWillEnterForeground:(UIApplication *)application
{
    // Called as part of the transition from the background to the inactive state; here you can undo many of the changes made on entering the background.
}

- (void)applicationDidBecomeActive:(UIApplication *)application
{
    // Restart any tasks that were paused (or not yet started) while the application was inactive. If the application was previously in the background, optionally refresh the user interface.
}

- (void)applicationWillTerminate:(UIApplication *)application
{
    // Called when the application is about to terminate. Save data if appropriate. See also applicationDidEnterBackground:.
}

@end

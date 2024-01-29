package com.jer.hirexpat.model



object JobData {

    val jobList = listOf<JobList>(
        JobList (
            1,
            "Software Engineer",
            "Google Indonesia",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Google_%22G%22_logo.svg/1200px-Google_%22G%22_logo.svg.png"
        ),
        JobList(
            2,
            "Machine Learning Engineer",
            "Apple Indonesia",
            "https://logowik.com/content/uploads/images/640_apple.jpg"
        ),
        JobList(
            3,
            "Cloud Indonesia",
            "Google LLC",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Google_%22G%22_logo.svg/1200px-Google_%22G%22_logo.svg.png"
        ),
        JobList(
            4,
            "Electrical Design Engineer",
            "CDM Smith",
            "https://www.cdmsmith.com/-/media/Images/CDMSmith_logo-1x1.jpg"
        ),
        JobList(
            5,
            "Product Designer",
            "GoTo Group",
            "https://asset.kompas.com/crops/gnn4jK0EwZ5haqSlgILZ3ixLWHM=/325x157:1196x737/750x500/data/photo/2021/05/17/60a1fdf5a7264.png"
        ),
        JobList(
            6,
            "UI Designer",
            "Nawatech",
            "https://vascomm.co.id/wp-content/uploads/2022/09/nawatech-2.png"
        ),
        JobList(
            7,
            "Accounting Finance",
            "Elabram Systems",
            "https://karirlab-prod-bucket.s3.ap-southeast-1.amazonaws.com/files/privates/O7MC5ChM9PUlov9jUwqJZyx1RUlnYKC4TZa16yyF.jpeg"
        ),
        JobList(
            8,
            "Head Civil Engineering & Infrastructure",
            "The Jakarta Consulting Group",
            "https://s3-ap-southeast-1.amazonaws.com/loket-production-sg/images/organization/20200413182345_5e944bc191918.png"
        ),
        JobList(
            9,
            "Project Manager",
            "PT Humana International Indonesia",
            "https://media.licdn.com/dms/image/C560BAQEgFuTUQYJZWA/company-logo_200_200/0/1658905214816?e=2147483647&v=beta&t=q2ll2GQ48-SuxIUbrTWA88DEDL8IDwQtYaU23AcXNE0"
        ),
        JobList(
            10,
            "Concept Artist",
            "Tripledot Studios",
            "https://naavik.co/wp-content/uploads/2022/02/tripleheader.jpeg"
        )

    )

    val jobRandom = jobList.shuffled()

    val job = listOf<Job>(
        Job(
            1,
            "Software Engineer",
            "Google Indonesia",
            "Collaborate on modeling techniques to support the full spectrum of LLM tuning including prompt engineering, instruction tuning, Reinforcement Learning from Human Feedback (RLHF), parameter-efficient tuning, and fine-tuning.Collaborate with stakeholders of LLMs and scope new research and product engagement opportunities.Bring state-of-the-art generative AI systems to Google and improve LLM efficiency.Lead multiple applied research projects that involve a broad set of stakeholders.Stay up to date on new research and chart the path forward to quality-driven production.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Google_%22G%22_logo.svg/1200px-Google_%22G%22_logo.svg.png"
        ),
        Job(
            2,
            "Machine Learning Engineer",
            "Apple Indonesia",
            "Develop test strategies and test plans for these products (e.g., system-level and product integration). Test automation implementation by using the scripting language (e.g., Python, Go).  Execute tests using sophisticated automated infrastructure.Test reporting automation such as dashboard.Manage data analysis, triaging failures, and collaborate with the stakeholders to debug. ",
            "https://logowik.com/content/uploads/images/640_apple.jpg"
        ),
        Job(
            3,
            "Cloud Engineer",
            "Google Indonesia",
            "Experience with Cloud Computing (i.e., SaaS, PaaS, IaaS) products or business models and related business strategies. Experience in direct client sales, customer support, or account management. Ability to present analyses and break down technical concepts into simple terms to present to diverse, technical, and non-technical audiences. Excellent problem-solving skills and the ability to manage highly strategic business problems. Ability to complete a 10-14 week internship at the assigned office in summer 2024 and to return to a MBA degree program after completion of the internship. Ability to communicate in English and Mandarin fluently.",
            "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Google_%22G%22_logo.svg/1200px-Google_%22G%22_logo.svg.png"
        ),
        Job(
            4,
            "Electrical Design Engineer",
            "CDM Smith",
            "Electrical design engineers develop new electrical systems for various applications. They research systems ideas and draw up plans for these systems, usually using a computer program. They are responsible for developing system specifications and layouts.",
            "https://www.cdmsmith.com/-/media/Images/CDMSmith_logo-1x1.jpg"
        ),
        Job(
            5,
            "Product Designer",
            "GoTo Group",
            "Identify problems and generate design solutions aligned with the product vision and requirements. Apply design best practices across projects, from gathering insights to validating problems and solutions. Deliver designs at various fidelity levels and ensure flawless implementation on production. Document your design journey meticulously, adhering to Tokopedia's standards. Showcase design progress to cross-functional teams, sharing the captivating story behind your designs. Work hand-in-hand with Interaction Designers and the Design System team to implement proper design components and patterns",
            "https://asset.kompas.com/crops/gnn4jK0EwZ5haqSlgILZ3ixLWHM=/325x157:1196x737/750x500/data/photo/2021/05/17/60a1fdf5a7264.png"
        ),
        Job(
            6,
            "UI Designer",
            "Nawatech",
            "Analyzing and actively discussing project requirements. Produce high-fidelity UI prototypes throughout the entire design process. Create any design materials needed for the product and actively collaborate with the engineering team. Write and manage technical documentation.",
            "https://vascomm.co.id/wp-content/uploads/2022/09/nawatech-2.png"
        ),
        Job(
            7,
            "Accounting Finance",
            "Elabram Systems",
            "A Financial Accountant is responsible for tasks such as gathering and monitoring financial data, preparing statements (balance sheets and income statements), forecasting costs and revenues, managing tax payments, organizing internal audits, and analyzing financial trends to support the company's financial decisions.",
            "https://karirlab-prod-bucket.s3.ap-southeast-1.amazonaws.com/files/privates/O7MC5ChM9PUlov9jUwqJZyx1RUlnYKC4TZa16yyF.jpeg"
        ),
        Job(
            8,
            "Head Civil Engineering & Infrastructure",
            "The Jakarta Consulting Group",
            "Analyzing survey reports, long-range plans, maps and other data to design new projects. Considering budget, regulations and environmental hazards during risk-analysis stage. Preparing material, equipment and labor cost estimates and confirming costs are within the budget. Forecasting design and construction timeline. Completing and submitting all permit applications to the appropriate agencies and ensuring projects are compliant throughout the design and construction stages. Overseeing soil testing to establish soil strength and building feasibility. Using design software to create project drawings and renderings. Managing repair and maintenance of infrastructure projects\n",
            "https://s3-ap-southeast-1.amazonaws.com/loket-production-sg/images/organization/20200413182345_5e944bc191918.png"
        ),
        Job(
            9,
            "Project Manager",
            "PT Humana International Indonesia",
            "Lead and guide the project team to work together to meet the project objectives and stakeholders expectations. Effectively communicate between the project sponsor, team members, client and other stakeholders . Provide vision and direction to the project team to successfully deliver all aspects of the project. Use appropriate leadership and emotional (soft) skills to balance conflicting and competing goals of the project stakeholders in order to achieve project",
            "https://humanainternational.com/wp-content/uploads/2023/02/Humana-International-logo.png"
        ),
        Job(
            10,
            "Concept Artist",
            "Tripledot Studios",
            "Create high quality, stylized concept art that communicates the visual look of the environment with various color, light & mood for pre-production. Ability to create different environments based on the location requirement that match the live game’s style. Design various props & layout of a location for production. Work closely with the Art Director & Lead and be collaborative with the team execute the task. Research and gather relevant reference to create the artworks. Iterate & do revisions of the artworks based on the feedbacks & reporting regularly to the Lead following schedule",
            "https://naavik.co/wp-content/uploads/2022/02/tripleheader.jpeg"
        )
    )
}